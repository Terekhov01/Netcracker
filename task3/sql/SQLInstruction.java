package task3.sql;

public class SQLInstruction {
    public static void main(String[] args) {
        System.out.println(getInstruction("PIN-22", 2));

    }
    public static String getInstruction(String id_Group, int dolgCount){
        return "INSERT INTO T_GroupSelected (id_Student, firstName, lastName, id_Group) " +
                "SELECT id_Student, firstName, lastName, id_Group " +
                "FROM T_Student WHERE id_Group = '" + id_Group + "' AND dolgCount = " + dolgCount;
    }
}
