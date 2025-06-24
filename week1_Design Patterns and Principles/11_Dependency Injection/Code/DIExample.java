interface CustomerRepository {
    String findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        return "Customer #" + id;
    }
}

class CustomerService {
    private CustomerRepository repo;
    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }
    public void showCustomer(int id) {
        System.out.println(repo.findCustomerById(id));
    }
}

public class DIExample {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.showCustomer(101);
    }
}
