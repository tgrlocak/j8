package com.tgrl.exp.j8.lambdas;


import static java.lang.System.out;

public class Scope {

  Runnable r1 = () -> out.println(this);
  Runnable r2 = () -> out.println(toString());

  public String toString() {
    return "Hello World!";
  }
  
  public static void main(String[] args) {
    new Scope().r1.run();
    new Scope().r2.run();
  }
  
  public void onlyOneAssignExample() {
    final String sql = "delete * from User";
    // getHibernateTemplate().execute(session ->  session.createSQLQuery(sql).uniqueResult());
  }
  
}
