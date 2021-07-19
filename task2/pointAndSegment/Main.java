package task2.pointAndSegment;

public class Main {
    public static void main(String[] args) {
        PointAndSegment pointAndSegment1 = new PointAndSegmentImpl();
        pointAndSegment1.setPointX(2);
        pointAndSegment1.setX1(-3);
        pointAndSegment1.setX2(2);
        pointAndSegment1.isInside();

        PointAndSegment pointAndSegment2 = new PointAndSegmentImpl();
        pointAndSegment2.setPointX(35);
        pointAndSegment2.setX1(20);
        pointAndSegment2.setX2(30);
        pointAndSegment2.isInside();
    }
}
