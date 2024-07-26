package main.Patron;

public class Patron {
        
        private String name;
        private String address;
        private String email;
        private String phoneNumber;
        private String libraryCardNumber;
    
        public Patron(String name, String address, String email, String phoneNumber, String libraryCardNumber) {
            this.name = name;
            this.address = address;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.libraryCardNumber = libraryCardNumber;
        }
    
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getLibraryCardNumber() {
            return libraryCardNumber;
        }
        
}
