package com.cmbb.smartkids.menglist;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.cmbb.smartkids.menglist.jazzy.JazzyEffect;

/**
 * 项目名称：MengBao
 * 类描述：通用ListView，包含功能：下拉刷新，上拉加载，加载失败和无数据
 * 创建人：N.Sun
 * 创建时间：2015/6/10 16:55
 */
public abstract class CommonListView implements SwipeRefreshLayout.OnRefreshListener, LoadMoreListView.OnLoadMoreListener {

    private Context mContext;

    //自动刷新间隔，默认5分钟
    private long refreshInterval = 1 * 60;
    // 数据适配器
    private CursorAdapter mCursorAdapter;

    //记录上次刷新成功的时间
    private long refreshTime = 0;

    // 下拉刷新
    private SwipeRefreshLayout mSwipeRefreshLayout;
    //ListView
    private LoadMoreListView mLoadMoreListView;
    //空值View
    private View container, emptyView;
    //空值提示
    private TextView emptyHint;
    //是否正在刷新
    private boolean refreshing = false;

    //当前请求的页码
    private int currentId = CURRENT_ID_INIT;

    public static int CURRENT_ID_INIT = -1;


    /**
     * 构造方面
     *
     * @param context
     */
    public CommonListView(Context context) {
        mContext = context;
        init();
    }

    /**
     * 获取布局文件
     *
     * @return 布局
     */
    public View getView() {
        return container;
    }

    /**
     * 设置自动刷新时间
     *
     * @param interval 时间间隔
     */
    public void setRefreshInterval(long interval) {
        this.refreshInterval = interval;
    }

    /**
     * 滑动到底部
     */
    public void scrollToBottom() {
        mLoadMoreListView.setSelection(mLoadMoreListView.getBottom());
    }

    /**
     * 设置动画效果
     *
     * @param jazzyEffect 效果
     */
    public void setJazzyEffect(JazzyEffect jazzyEffect) {
        mLoadMoreListView.setTransitionEffect(jazzyEffect);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        mLoadMoreListView.setOnScrollListener(onScrollListener);
    }

    /**
     * 单击事件
     *
     * @param onItemClickListener 监听器
     */
    public void setOnItemClickListener(CompatOnItemClickListener onItemClickListener) {
        mLoadMoreListView.setOnItemClickListener(onItemClickListener);
    }

    /**
     * 是否开启加载更多功能
     *
     * @param isEnable 是否
     */
    public void enableLoadMore(boolean isEnable) {
        mLoadMoreListView.setEnableLoadMore(isEnable);
    }

    /**
     * 长按事件
     *
     * @param longClickListener 监听器
     */
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener longClickListener) {
        mLoadMoreListView.setOnItemLongClickListener(longClickListener);
    }

    /**
     * 初始化
     */
    private void init() {
        container = View.inflate(mContext, R.layout.meng_listview_layout, null);
        mSwipeRefreshLayout = (SwipeRefreshLayout) container.findViewById(R.id.refresh_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mLoadMoreListView = (LoadMoreListView) mSwipeRefreshLayout.findViewById(R.id.list_view);
        mLoadMoreListView.setTransitionEffect(jazzyEffect);
        mCursorAdapter = getAdapter(mContext);
        mLoadMoreListView.setAdapter(mCursorAdapter);
        mLoadMoreListView.setOnLoadMoreListener(this);
        emptyView = container.findViewById(R.id.empty_view);
        emptyHint = (TextView) container.findViewById(R.id.empty_hint);
        // 无数据，点击刷新
        emptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh(false);
            }
        });
    }

    /**
     * 停止刷新或加载更多
     *
     * @param id
     * @param loadMoreSuccess
     */
    private void stopRefreshOrLoadMore(int id, boolean loadMoreSuccess) {
        if (id == CURRENT_ID_INIT) {
            refreshFinished();
        } else {
            mLoadMoreListView.stopLoadMore(loadMoreSuccess);
        }
    }

    /**
     * 刷新或加载更多失败
     */
    private void refreshOrLoadMoreFailure() {
        if (mCursorAdapter.isEmpty()) {
            emptyHint.setText(R.string.load_failure);
            emptyView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 没有数据
     */
    private void noData() {
        if (mCursorAdapter.isEmpty()) {
            emptyHint.setText(R.string.no_data);
            emptyView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 刷新完成
     */
    private void refreshFinished() {
        refreshing = false;
        mLoadMoreListView.setRefreshing(false);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    /**
     * 刷新
     *
     * @param rightNow 是否立即刷新 false时判断刷新间隔是否满足自动刷新条件
     */
    public void refresh(boolean rightNow) {
        if (emptyView.getVisibility() == View.VISIBLE) {
            emptyView.setVisibility(View.GONE);
        }
        //如果正在加载更多或者正在刷新或者不满足自动刷新条件，取消操作
        if (mLoadMoreListView.isLoadingMore() || refreshing || (!rightNow && (System.currentTimeMillis() / 1000 - refreshTime) < refreshInterval)) {
            return;
        }
        if (!mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(true);
        }
        refreshing = true;
        mLoadMoreListView.setRefreshing(true);
        getDataFromServer(-1);
    }

    /**
     * 获取数据成功
     *
     * @param id     页码
     * @param cursor 返回的数据
     */
    public void onGetDataSuccess(int id, Cursor cursor, long refreshTime) {
        stopRefreshOrLoadMore(currentId, true);
        if (cursor == null || cursor.getCount() <= 0) {
            noData();
        } else {
            if (currentId == CURRENT_ID_INIT) {
                this.refreshTime = refreshTime;
            }
            currentId = id;
        }
    }

    /**
     * 获取数据失败
     *
     * @param id 页码
     */
    public void onGetDataFailure(int id) {
        stopRefreshOrLoadMore(id, false);
        refreshOrLoadMoreFailure();
    }

    /**
     * 列表滑动时的显示效果
     */
    private final JazzyEffect jazzyEffect = new JazzyEffect() {

        private final float SCALE = 0.9f,
                FINAL = 1.0f;

        @Override
        public void initView(View item, int position, int scrollDirection) {
            if (item == null)
                return;
            item.setScaleX(SCALE);
            item.setScaleY(SCALE);
        }

        @Override
        public void setupAnimation(View item, int position, int scrollDirection, ViewPropertyAnimator animator) {
            if (item == null || animator == null)
                return;
            animator.scaleX(FINAL);
            animator.scaleY(FINAL);
        }
    };

    @Override
    public void onRefresh() {
        if (mLoadMoreListView.isLoadingMore()) {
            mSwipeRefreshLayout.setRefreshing(false);
            return;
        }
        currentId = CURRENT_ID_INIT;
        refresh(true);
    }

    @Override
    public void onLoadMore() {
        getDataFromServer(currentId);
    }

    /**
     * 获取最终的适配器
     *
     * @return 适配器
     */
    public abstract CursorAdapter getAdapter(Context context);

    /**
     * 从网络获取数据
     *
     * @param currentId ID
     */
    public abstract void getDataFromServer(int currentId);
}
