package com.codename1.demos.kitchen.charts;

import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.util.MathHelper;
import com.codename1.charts.views.PointStyle;
import com.codename1.charts.views.ScatterChart;
import com.codename1.charts.views.TimeChart;
import com.codename1.ui.Component;
import com.codename1.ui.Display;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TimeChartDemo extends AbstractDemoChart {
    private XYMultipleSeriesDataset dataSet;
    private List<Date[]> x;

    private static final long HOUR = 3600 * 1000;

    private static final long DAY = HOUR * 24;

    private static final int HOURS = 24;

    public Component execute() {
        int[] colors = new int[]{ColorUtil.GREEN, ColorUtil.BLUE};
        PointStyle[] styles = new PointStyle[]{PointStyle.CIRCLE, PointStyle.DIAMOND};
        XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
        int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).setFillPoints(true);
        }

        // lazy initialization of x...
        getDataSet();
        setChartSettings(renderer, "Sensor temperature", "Hour", "Celsius degrees",
                x.get(0)[0].getTime(), x.get(0)[HOURS - 1].getTime(), -5, 30, ColorUtil.LTGRAY, ColorUtil.LTGRAY);

        int strWidth = Display.getInstance().convertToPixels(25);

        int numXLabels = Display.getInstance().getDisplayWidth() / (strWidth + 20);

        renderer.setXLabels(numXLabels);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Component.CENTER);
        renderer.setYLabelsAlign(Component.RIGHT);
        initRendererer(renderer);

        TimeChart chart = new TimeChart(getDataSet(),
                renderer);
        return newChart(chart);
    }

    private XYMultipleSeriesDataset getDataSet() {
        if(dataSet == null) {
            String[] titles = new String[]{"Inside", "Outside"};
            long now = Math.round(new Date().getTime() / DAY) * DAY;
            x = new ArrayList<Date[]>();
            for (int i = 0; i < titles.length; i++) {
                Date[] dates = new Date[HOURS];
                for (int j = 0; j < HOURS; j++) {
                    dates[j] = new Date(now - (HOURS - j) * HOUR);
                }
                x.add(dates);
            }
            List<double[]> values = new ArrayList<double[]>();

            values.add(new double[]{21.2, 21.5, 21.7, 21.5, 21.4, 21.4, 21.3, 21.1, 20.6, 20.3, 20.2,
                    19.9, 19.7, 19.6, 19.9, 20.3, 20.6, 20.9, 21.2, 21.6, 21.9, 22.1, 21.7, 21.5});
            values.add(new double[]{1.9, 1.2, 0.9, 0.5, 0.1, -0.5, -0.6, MathHelper.NULL_VALUE,
                    MathHelper.NULL_VALUE, -1.8, -0.3, 1.4, 3.4, 4.9, 7.0, 6.4, 3.4, 2.0, 1.5, 0.9, -0.5,
                    MathHelper.NULL_VALUE, -1.9, -2.5, -4.3});
            dataSet = buildDateDataset(titles, x, values);
        }
        return dataSet;
    }

}
