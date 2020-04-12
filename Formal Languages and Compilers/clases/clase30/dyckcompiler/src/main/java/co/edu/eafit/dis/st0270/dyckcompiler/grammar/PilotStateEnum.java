package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public enum PilotStateEnum {

    I0(true),
    I1(),
    I2(),
    I3(true),
    I4(),
    I5(true),
    I6(),
    I7(true),
    I8(),
    I9(true),
    I10();

    private boolean reduction = false;

    PilotStateEnum(boolean reduction) {
	this.reduction = reduction;
    }

    PilotStateEnum() {
    }

    public boolean isAReductionState() {
	return reduction;
    }
}