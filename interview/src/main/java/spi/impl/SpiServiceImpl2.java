package spi.impl;

import spi.SpiService;

public class SpiServiceImpl2 implements SpiService {
    @Override
    public void process() {
        System.out.println("SpiServiceImpl2.process...");
    }
}
