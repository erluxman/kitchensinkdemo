package com.codename1.demos.kitchen.charts;

import com.codename1.charts.compat.Canvas;
import com.codename1.charts.compat.Paint;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.DialRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.util.MathHelper;
import com.codename1.charts.views.PieChart;
import com.codename1.charts.views.RoundChart;
import com.codename1.ui.Component;

public class RoundChartDemo extends AbstractDemoChart {
    public Component execute() {
        double[] values = new double[]{12, 14, 11, 10, 19};
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
        final DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        initRendererer(renderer);

        final CategorySeries seriesSet = buildCategoryDataset("Home", values);
        renderer.setScale(0.3f);
        RoundChart roundChart = new RoundChart(seriesSet, renderer) {
            @Override
            public void draw(Canvas canvas, int x, int y, int width, int height, Paint paint) {
                paint.setAntiAlias(mRenderer.isAntialiasing());
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(ColorUtil.GREEN);
                paint.setTextSize(mRenderer.getLabelsTextSize());
                canvas.drawCircle(x,y,(float) Math.sqrt((width*width+height*height)),paint);
            }
        };
        return newChart(roundChart);
    }
}
