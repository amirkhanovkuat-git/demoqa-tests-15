package com.demoqa.utils;

import java.util.Random;

public enum GenerateMonth {
    January, February, March, April,
    May, June, July, August,
    September, October, November, December;

    public static GenerateMonth randomMonth() {
        int pick = new Random().nextInt(GenerateMonth.values().length);
        return GenerateMonth.values()[pick];
    }
}
