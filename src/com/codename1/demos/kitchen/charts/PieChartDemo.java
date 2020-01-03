package com.codename1.demos.kitchen.charts;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.models.SeriesSelection;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Component;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.geom.Shape;

public class PieChartDemo extends AbstractDemoChart {
    public Component execute() {
        double[] values = new double[]{12, 14, 11, 10, 19};
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
        final DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        initRendererer(renderer);

        final CategorySeries seriesSet = buildCategoryDataset("Home", values);
        final PieChart chart = new PieChart(seriesSet, renderer);
        return newChart(chart);
    }
}
