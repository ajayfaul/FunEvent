package com.morningstar.funevent.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.morningstar.funevent.R;
import com.morningstar.funevent.model.OnBoardingModel;

import java.util.List;

public class OnBoardingViewPagerAdapter extends PagerAdapter {

    Context mContext ;
    List<OnBoardingModel> mListScreen;

    public OnBoardingViewPagerAdapter(Context mContext, List<OnBoardingModel> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View onBoardingScreen = inflater.inflate(R.layout.onboarding_screen,null);

        ImageView imgSlide = onBoardingScreen.findViewById(R.id.onboardingImg);
        TextView title = onBoardingScreen.findViewById(R.id.onboardingTitle);
        TextView description = onBoardingScreen.findViewById(R.id.onboardingDescription);

        title.setText(mListScreen.get(position).getTitle());
        description.setText(mListScreen.get(position).getDescription());
        imgSlide.setImageResource(mListScreen.get(position).getOnBoardingImg());

        container.addView(onBoardingScreen);

        return onBoardingScreen;



    }
    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);

    }
}
