package task2.pointAndSegment;

public interface PointAndSegment {
    /**
     * Устанавливает точку на оси Ох
     * @param value
     */
    void setPointX(int value);

    /**
     * Устанавливает начало отрезка
     * @param value
     */
    void setX1(int value);

    /**
     * Устанавливает конец отрезка
     * @param value
     */
    void setX2(int value);

    /**
     * Проверка нахождения точки на отрезке
     * @return результат проверки
     */
    boolean isInside();
}
