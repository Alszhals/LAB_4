public class MyTestingClass {

        private int id;
        private String name;

        public MyTestingClass(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MyTestingClass other = (MyTestingClass) obj;
            return id == other.id && (name != null ? name.equals(other.name) : other.name == null);
        }
    }


