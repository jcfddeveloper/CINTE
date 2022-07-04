package co.com.jcfd.pruebaRestFull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.jcfd.pruebaRestFull.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
