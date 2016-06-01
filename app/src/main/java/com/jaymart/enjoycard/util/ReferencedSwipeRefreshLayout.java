package com.jaymart.enjoycard.util;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;


public class ReferencedSwipeRefreshLayout extends SwipeRefreshLayout {
    public ReferencedSwipeRefreshLayout(Context context) {
        super(context);
    }

    public ReferencedSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean canChildScrollUp() {
        if (getChildAt(0) == null) {
            if (getChildCount() > 1 && !isInEditMode()) {
                throw new IllegalStateException(
                        "SwipeRefreshLayout can host only one direct child");
            }
        }
        View view = searchRecursively((ViewGroup) getChildAt(0));
        if (view != null) {
            return view.canScrollVertically(-1);
        }
        return true;
    }

    private View searchRecursively(ViewGroup parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                View tmp = searchRecursively((ViewGroup) child);
                if (tmp != null) {
                    if (tmp instanceof ScrollView) {
                        return tmp;
                    }
                    if (tmp instanceof ListView) {
                        return tmp;
                    }

                    if (tmp instanceof RecyclerView) {
                        return tmp;
                    }
                }
            }
            if (child != null) {
                if (child instanceof ScrollView) {
                    return child;
                }
                if (child instanceof ListView) {
                    return child;
                }

                if (child instanceof RecyclerView) {
                    return child;
                }
            }
        }
        return null;
    }
}
