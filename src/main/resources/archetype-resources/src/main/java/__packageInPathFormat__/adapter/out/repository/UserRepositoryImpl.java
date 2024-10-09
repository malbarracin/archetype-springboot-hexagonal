package ${package}.adapter.out.repository;

import ${package}.domain.model.User;
import ${package}.domain.ports.UserRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryImpl extends CrudRepository<User, Long>, UserRepository {
}
