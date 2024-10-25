public class Java17MultilineStrings {

    public static void main(String[] args) {

        var newSqlQuery = """
                SELECT e.emp_name, d.dept_name, p.project_name
                from Employee e
                INNER JOIN dept d ON e.dept_id = d.dept_id
                INNER JOIN project p ON e.project_id = p.project_id
                where d.dept_name="finance" and e.emp_name="Peter";
                """.strip();
        System.out.println(newSqlQuery);

        var newComplexJson = """
                 [{
                     "Status": {
                         "verified": true,
                         "sentCount": 1
                     }
                 }]
                """.strip();
        System.out.println(newComplexJson);
    }
}

