public class Subject {
   private String num;
   private String name;
   private String prname;
   private String day;
   private String type;
   
   
   public Subject(String num, String name, String prname, String day, String type) {
      super();
      this.num = num;
      this.name = name;
      this.prname = prname;
      this.day = day;
      this.type = type;
   }
   public String getNum() {
      return num;
   }
   public void setNum(String num) {
      this.num = num;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getPrname() {
      return prname;
   }
   public void setPrname(String prname) {
      this.prname = prname;
   }
   public String getDay() {
      return day;
   }
   public void setDay(String day) {
      this.day = day;
   }
   public String getType() {
      return type;
   }
   public void setType(String type) {
      this.type = type;
   }
   
   
}