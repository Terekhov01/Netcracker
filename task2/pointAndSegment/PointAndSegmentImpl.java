package task2.pointAndSegment;

public class PointAndSegmentImpl implements PointAndSegment{
    private int pointX;
    private int x1;
    private int x2;
    @Override
    public void setPointX(int value) {
        pointX = value;
    }

    @Override
    public void setX1(int value) {
        x1 = value;
    }

    @Override
    public void setX2(int value) {
        x2 = value;
    }

    @Override
    public boolean isInside() {
        if(pointX >= x1 && pointX <= x2){
            System.out.println("Заданная точка " + pointX +
                    " находится внутри отрезка [" + x1 + "; " + x2 + "]");
            return true;
        }
        System.out.println("Заданная точка " + pointX +
                " НЕ находится внутри отрезка [" + x1 + "; " + x2 + "]");
        return false;
    }
}
