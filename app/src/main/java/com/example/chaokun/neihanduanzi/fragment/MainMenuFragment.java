package com.example.chaokun.neihanduanzi.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chaokun.neihanduanzi.R;
import com.example.chaokun.neihanduanzi.activity.MainActivity;
import com.example.chaokun.neihanduanzi.activity.SettingActivity;
import com.example.chaokun.neihanduanzi.base.BaseFragment;
import com.example.chaokun.neihanduanzi.bean.MenuItem;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainMenuFragment extends BaseFragment {

    @InjectView(R.id.rl_container)
    RelativeLayout rlContainer;

    @InjectView(R.id.recycler_view)
    RecyclerView recyclerView;
    private MainActivity mainActivity;
    private MenuAdapter mAdapter;

    private MenuItem.FragmentType currentFragment = MenuItem.FragmentType.music;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);
        ButterKnife.inject(this, view);

        rlContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SettingActivity.class));
                mainActivity.closeDrawer();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new MenuAdapter();
        addAllMenuItems(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);

    }

    private  class MenuAdapter extends RecyclerView.Adapter<ViewHolder>{
        private ArrayList<MenuItem> menuItems;
        public MenuAdapter() {
            menuItems = new ArrayList<>();
        }
        @Override
        public int getItemCount() {
            return menuItems.size();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_item,
                    parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final MenuItem item = menuItems.get(position);
            holder.img_menu.setImageResource(item.getResourceId());
            holder.tv_title.setText(item.getTitle());
            holder.rl_container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        if(currentFragment!=item.getType()){
                            Fragment fragment = (Fragment)Class.forName(item.getFragment().getName()).newInstance();
                            mainActivity.replaceFragment(R.id.frame_container,fragment);
                            currentFragment = item.getType();
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                        mainActivity.closeDrawer();
                }
            });
        }
    }
    private static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_menu;
        private TextView tv_title;
        private RelativeLayout rl_container;


        public ViewHolder(View itemView) {
            super(itemView);
            img_menu = (ImageView) itemView.findViewById(R.id.img_menu);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            rl_container = (RelativeLayout) itemView.findViewById(R.id.rl_container);
        }
    }

    private void addAllMenuItems(MenuAdapter mAdapter) {
        mAdapter.menuItems.clear();
        mAdapter.menuItems.add(new MenuItem("好声音", R.mipmap.ic_explore_white_24dp, MenuItem.FragmentType.music,
                MusicFragment.class));
        mAdapter.menuItems.add(new MenuItem("无聊图", R.mipmap.ic_mood_white_24dp, MenuItem.FragmentType.BoringPicture,
                PictureFragment.class));
        mAdapter.menuItems.add(new MenuItem("美女图", R.mipmap.ic_local_florist_white_24dp, MenuItem.FragmentType.Sister,
                SisterFragment.class));
        mAdapter.menuItems.add(new MenuItem("小段子", R.mipmap.ic_chat_white_24dp, MenuItem.FragmentType.Joke, JokeFragment
                .class));
        mAdapter.menuItems.add(new MenuItem("小电影", R.mipmap.ic_movie_white_24dp, MenuItem.FragmentType.Video,
                VideoFragment.class));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}