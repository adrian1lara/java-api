package com.init.RestProductosDae2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.RestProductosDae2.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{
	Producto findById(int id);
	List<Producto> findAll();
	void deleteById(int id);
}
