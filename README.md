# Android50
安卓5.0新特性
 新控件
    RecyclerView
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            mRl = (RecyclerView) findViewById(R.id.rl);
            LinearLayoutManager manager = new LinearLayoutManager(this);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            mRl.setLayoutManager(manager);
            mRl.setAdapter(new HomeAdapter());
        }

        private class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {
            @Override
            public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = View.inflate(getApplicationContext(), android.R.layout
                        .simple_list_item_1, null);
                return new HomeHolder(view);
            }

            @Override
            public void onBindViewHolder(HomeHolder holder, int position) {
                holder.mTv.setText(Cheeses.NAMES[position]);
            }

            @Override
            public int getItemCount() {
                return Cheeses.NAMES.length;
            }
        }

        class HomeHolder extends RecyclerView.ViewHolder{
            TextView mTv;
            public HomeHolder(View itemView) {
                super(itemView);
    //            mTv = (TextView) itemView.findViewById(android.R.id.text1);
                mTv = (TextView) itemView;
            }
        }
    SwipeRefreshLayout
        <android.support.v4.widget.SwipeRefreshLayout
            android:id="@+id/sfl"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <android.support.v7.widget.RecyclerView
                android:id="@+id/rl"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:background="#0F0"></android.support.v7.widget.RecyclerView>
        </android.support.v4.widget.SwipeRefreshLayout>
     ToolBar(替代ActionBar)
        setActionBar(toolbar);
    CardView
        相当于 FrameLayout
    12.5. compile 'com.android.support:design:23.1.1'
    以上控件都可以向下兼容
