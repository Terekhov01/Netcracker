package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements2Impl implements ControlFlowStatements2{
    @Override
    public int getFunctionValue(int x) {
        int f;
        if (Math.abs(x) > 2)
            f = 2*x;
        else
            f = -3*x;
        return f;
    }

    @Override
    public String decodeMark(int mark) {
        switch (mark) {
            case 1:
                return "Fail";
            case 2:
                return "Poor";
            case 3:
                return "Satisfactory";
            case 4:
                return "Good";
            case 5:
                return "Excellent";
        }
        return "Error";
    }

    @Override
    public double[][] initArray() {
        double[][] arr = new double[5][8];
        for(int i=0;i<5;i++)
            for (int j=0;j<8;j++)
                arr[i][j] = Math.pow(i,4) - Math.sqrt(j);
        return arr;
    }

    @Override
    public double getMaxValue(double[][] array) {
        double max = array[0][0];
        for(int i=0;i<array.length;i++)
            for (int j=0;j<array[i].length;j++){
                if(array[i][j] > max)
                    max = array[i][j];
            }
        return max;
    }

    @Override
    public Sportsman calculateSportsman(float P) {
        Sportsman sportsman = new Sportsman();
        float distance = 10;
        sportsman.addDay(distance);
        while (sportsman.getTotalDistance() <= 200){
            distance *= (1+P/100);
            sportsman.addDay(distance);
        }
        return sportsman;
    }
}
