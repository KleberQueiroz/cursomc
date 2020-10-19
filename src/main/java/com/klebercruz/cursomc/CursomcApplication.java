package com.klebercruz.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.klebercruz.cursomc.domain.Categoria;
import com.klebercruz.cursomc.domain.Cidade;
import com.klebercruz.cursomc.domain.Cliente;
import com.klebercruz.cursomc.domain.Endereco;
import com.klebercruz.cursomc.domain.Estado;
import com.klebercruz.cursomc.domain.Produto;
import com.klebercruz.cursomc.domain.enums.TipoCliente;
import com.klebercruz.cursomc.repositories.CategoriaRepository;
import com.klebercruz.cursomc.repositories.CidadeRepository;
import com.klebercruz.cursomc.repositories.ClienteRepository;
import com.klebercruz.cursomc.repositories.EnderecoRepository;
import com.klebercruz.cursomc.repositories.EstadoRepository;
import com.klebercruz.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Categoria cat1 = new Categoria (null, "Informatica");
		Categoria cat2 = new Categoria (null, "Escritorio");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",2000.00);
		Produto p3 = new Produto(null,"Mouse",2000.00);
	
		Estado est1 =new Estado(null, "Minas Gerais");
		Estado est2 =new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia", est1);
		Cidade c2 = new Cidade(null,"São Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
	
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","Maria@gmail.com",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList(" 1354564-131","3154354-32131"));
		
		Endereco e1 = new Endereco(null, "Rua Silvio"," 194"," 201", "Buritis", "305745-150", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Kleber Cruz"," 194"," 201", "Buritis", "305745-150", cli1, c2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
	}

	
}
