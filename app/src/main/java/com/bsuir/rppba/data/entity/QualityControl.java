package com.bsuir.rppba.data.entity;

public class QualityControl extends Entity {

    private boolean isFirstCheckPassed;
    private boolean isSecondCheckPassed;

    public QualityControl(boolean isFirstCheckPassed, boolean isSecondCheckPassed) {
        this.isFirstCheckPassed = isFirstCheckPassed;
        this.isSecondCheckPassed = isSecondCheckPassed;
    }

    public QualityControl() {
        this.isFirstCheckPassed = false;
        this.isSecondCheckPassed = false;
    }

    public boolean isFirstCheckPassed() {
        return isFirstCheckPassed;
    }

    public void setFirstCheckPassed(boolean firstCheckPassed) {
        isFirstCheckPassed = firstCheckPassed;
    }

    public boolean isSecondCheckPassed() {
        return isSecondCheckPassed;
    }

    public void setSecondCheckPassed(boolean secondCheckPassed) {
        isSecondCheckPassed = secondCheckPassed;
    }

}
