package me.bakumon.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 宽高比 ImageView
 * Created by bakumon on 17-7-27.
 */

public class RatioImageView extends ImageView {

    private int ratioWidth;
    private int ratioHeight;

    public RatioImageView(Context context) {
        this(context, null);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        String ratioAttr = a.getString(R.styleable.RatioImageView_dimensionRatio);
        if (!TextUtils.isEmpty(ratioAttr)) {
            try {
                String[] ratio = ratioAttr.split(":");
                if (ratio.length > 1) {
                    ratioWidth = Integer.parseInt(ratio[0]);
                    ratioHeight = Integer.parseInt(ratio[1]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        a.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (ratioWidth == 0 || ratioHeight == 0) {
            return;
        }

        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();

        if ((measuredHeight == 0 && measuredWidth != 0)) {
            setMeasuredDimension(measuredWidth, measuredWidth * ratioHeight / ratioWidth);
        }

        if ((measuredWidth == 0 && measuredHeight != 0)) {
            setMeasuredDimension(measuredHeight * ratioWidth / ratioHeight, measuredHeight);
        }
    }

    public void setDimensionRatio(int ratioWidth, int ratioHeight) {
        this.ratioWidth = ratioWidth;
        this.ratioHeight = ratioHeight;
        requestLayout();
    }
}
