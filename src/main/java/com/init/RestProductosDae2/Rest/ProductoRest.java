package com.init.RestProductosDae2.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.RestProductosDae2.entity.Producto;
import com.init.RestProductosDae2.repository.ProductoRepository;

@RestController
@RequestMapping("productos")
public class ProductoRest {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping
	public ResponseEntity<List<Producto>> getProductos(){
		List<Producto> listaProductos = productoRepository.findAll();
		return ResponseEntity.ok(listaProductos);
	}
	
	@RequestMapping(value="{productoId}")
	public ResponseEntity<Producto> getProductoxId(@PathVariable("productoId")int id){
		Producto producto = productoRepository.findById(id);
		return ResponseEntity.ok(producto);
	}
	
	@PostMapping
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
		Producto nuevoProducto = productoRepository.save(producto);
		return ResponseEntity.ok(nuevoProducto);
	}
	
	@PutMapping
	public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto){
		Producto productoBD = productoRepository.findById(producto.getId());
		productoBD.setNombre(producto.getNombre());
		productoRepository.save(productoBD);
		return ResponseEntity.ok(productoBD);
	}
	
	@DeleteMapping(value="{productoId}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable("productoId")int id){
		productoRepository.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
}
