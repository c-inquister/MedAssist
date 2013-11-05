package com.deloitte.google.medassist.adapter;

import java.util.Collection;
import java.util.List;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;

import com.deloitte.google.medassist.R;
import com.deloitte.google.medassist.utils.DeviceOSFeatureUtils;

public class CustomBaseArrayAdapter<T> extends ArrayAdapter<T> {

    protected final LayoutInflater mInflater;
    protected final Animation mProgressAnimation;

    public CustomBaseArrayAdapter(Context context, List<T> list) {
        this(context, 0, list);
    }

    public CustomBaseArrayAdapter(Context context, int textViewResourceId, List<T> list) {
        super(context, textViewResourceId, list);
        mInflater = LayoutInflater.from(context);
        mProgressAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.rotate);
    }

    @Override
    public void addAll(Collection<? extends T> collection) {
        addAllItems(collection);
    }

    @SuppressLint("NewApi")
    @TargetApi(8)
    public void addAllItems(Collection<? extends T> collection) {
        if (DeviceOSFeatureUtils.hasHoneycomb()) {
            super.addAll(collection);
        } else {
            for (T item: collection) {
                add(item);
            }
        }
    }

    @Override
    public void addAll(T... items) {
        addAllItems(items);
    }

    @SuppressLint("NewApi")
    @TargetApi(8)
    public void addAllItems(T... items) {
        if (DeviceOSFeatureUtils.hasHoneycomb()) {
            super.addAll(items);
        } else {
            for (T item: items) {
                add(item);
            }
        }
    }

}