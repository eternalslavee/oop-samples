package com.di;

// Interface to handle bonuses
interface BonusEligible {
    // Static constant
    double DEFAULT_BONUS = 5000.00;

    double getBonus();
    void setBonus(double bonus);
}
