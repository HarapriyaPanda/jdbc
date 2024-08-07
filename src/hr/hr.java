package hr;

public class hr {

        private String name01;
        private String name02;
        private String dept;
        private String city;
        private String state;

        // Getter and Setter for name01
        public String getName01() {
            return name01;
        }

        public void setName01(String name01) {
            this.name01 = name01;
        }

        // Getter and Setter for name02
        public String getName02() {
            return name02;
        }

        public void setName02(String name02) {
            this.name02 = name02;
        }

        // Getter and Setter for dept
        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        // Getter and Setter for city
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        // Getter and Setter for state
        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }


        public String toString() {
            return "HR{" + "name01='" + name01 + '\'' + ", name02='" + name02 + '\'' + ", dept='" + dept + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + '}';
        }
    }


