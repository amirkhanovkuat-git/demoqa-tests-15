package com.demoqa.utils;

import java.util.Random;

public enum generateMonth {
    January, February, March, April,
    May, June, July, August,
    September, October, November, December;

    public static generateMonth randomMonth() {
        int pick = new Random().nextInt(generateMonth.values().length);
        return generateMonth.values()[pick];
    }
}
