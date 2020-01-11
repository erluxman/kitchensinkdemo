package com.codename1.demos.kitchen.charts;

import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.models.MultipleCategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.DialRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.DialChart;
import com.codename1.ui.Component;

public class DialChartDemo extends AbstractDemoChart {

    public Component execute() {
        CategorySeries category = new CategorySeries("Temperature (F)");
        category.add("Maximum", 95);
        category.add("Minimum", 35);
        DialRenderer renderer = new DialRenderer();

        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(ColorUtil.BLUE);
        renderer.addSeriesRenderer(r);
        r = new SimpleSeriesRenderer();
        r.setColor(ColorUtil.GREEN);
        renderer.addSeriesRenderer(r);
        initRendererer(renderer);

        DialChart chart = new DialChart(category, renderer);
        return newChart(chart);
    }
}
