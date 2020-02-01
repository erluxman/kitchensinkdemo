package com.codename1.demos.kitchen.containers.containerdemos;

import com.codename1.components.InfiniteProgress;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.CommonProgressAnimations;
import com.codename1.ui.Container;
import com.codename1.ui.Slider;

class ProgressDemo extends DemoComponent {

    @Override
    public String getImageName() {
        return "progress.png";
    }

    @Override
    public String getTitle() {
        return "Progress";
    }

    @Override
    Container getContent() {
        return progressContainer();
    }

    private Container progressContainer() {
        ComponentDemo demo = new ComponentDemo("Progress");
        InfiniteProgress infiniteProgress = new InfiniteProgress();

        Slider slider = new Slider();
        slider.setProgress(50);
        slider.setEditable(true);

        demo.add("Infinite Progress", infiniteProgress);
        demo.add("Slider", slider);
        demo.add("Circle Animation", new CommonProgressAnimations.CircleProgress());
        demo.add("Text Loading Animation", new CommonProgressAnimations.LoadingTextAnimation().rows(2).cols(1));

        return demo.generate();
    }
}
