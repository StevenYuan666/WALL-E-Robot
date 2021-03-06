package Code;

public class EmptyCompactor extends BasicAction{
    //Since the action is not for a specific robot, we can implement singleton here
    private static final EmptyCompactor aInstance = new EmptyCompactor();

    private EmptyCompactor(){}

    public static EmptyCompactor getInstance(){
        return EmptyCompactor.aInstance;
    }

    @Override
    public void execute(Robot r) throws RobotDamagedException {
        if(r.getCompactorLevel() > 0){
            super.execute(r);
            //Do the action
            r.emptyCompactor();
            //Update the level of charge
            r.updateBatteryLevel();
        }
        else{
            //Throw a warning message
            throw new RobotDamagedException("Warning: Compactor has been emptied.");
        }
    }

    @Override
    public String toString(){
        return "EmptyCompactor";
    }

    @Override
    public Object accept(Visitor pVisitor) {
        return pVisitor.visitEmptyCompactor(this);
    }
}
