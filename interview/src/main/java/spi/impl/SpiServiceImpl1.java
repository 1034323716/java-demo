package spi.impl;

import spi.SpiService;

public class SpiServiceImpl1 implements SpiService {
    @Override
    public void process() {
        System.out.println("SpiServiceImpl1.process...");
    }
}
