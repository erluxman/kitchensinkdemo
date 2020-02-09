package com.codename1.demos.kitchen.componentdemos.charts;

import com.codename1.charts.models.AreaSeries;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.RadarChart;
import com.codename1.ui.Component;

public class RadarChartDemo extends AbstractDemoChart {

    @Override
    public Component execute() {
        double[] values = new double[]{12, 14, 11, 10, 19};
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
        final DefaultRenderer renderer = buildCategoryRenderer(colors);

        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        initRendererer(renderer);
        AreaSeries s = new AreaSeries();
        s.addSeries(buildCategoryDataset("dad",values));
        final CategorySeries seriesSet = buildCategoryDataset("Home", values);
        return newChart(new RadarChart(s, renderer));
    }
}
