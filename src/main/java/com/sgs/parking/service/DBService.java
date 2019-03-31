package com.sgs.parking.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgs.parking.domain.Cliente;
import com.sgs.parking.domain.Estacionamento;
import com.sgs.parking.domain.Patio;
import com.sgs.parking.domain.Periodo;
import com.sgs.parking.domain.Usuario;
import com.sgs.parking.domain.Veiculo;
import com.sgs.parking.repositories.ClienteRepository;
import com.sgs.parking.repositories.EstacionamentoRepository;
import com.sgs.parking.repositories.PatioRepository;
import com.sgs.parking.repositories.PeriodoRepository;
import com.sgs.parking.repositories.UsuarioRepository;
import com.sgs.parking.repositories.VeiculoRepository;


@Service
public class DBService {


	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	@Autowired 
	private PatioRepository patioRepository;
	@Autowired
	private PeriodoRepository periodoRepository;
	
	public void instantiateTestDataBase() throws ParseException {

		
		Cliente cli1 = new Cliente(null,"Leo Falcão", "152092370111", "2332020");
		Cliente cli2 = new Cliente(null,"Lula Silva", "152038695110", "2412000");
		Cliente cli3 = new Cliente(null,"Leo Hawk", "15607303111", "5656565656");
		
		Usuario user1 = new Usuario(null, "Usuario 01", "12345");
		Usuario user2 = new Usuario(null, "Usuario 02", "12345");
				
		
		Veiculo carro1 = new Veiculo(null, "nvq 6831", "GOl", "Azul");
		Veiculo carro2 = new Veiculo(null , "nvq 6832", "Palio","Vermelho");
		Veiculo carro3 = new Veiculo(null, "nvq 6833","Sandero", "Prata");
		Veiculo carro4 = new Veiculo(null, "nvq 6834","Tucson", "Preto");
		Veiculo carro5 = new Veiculo(null,"nvq 6835", "Fox", "Cinza");
		Veiculo carro6 = new Veiculo(null, "nvq 6836", "Siena", "Branco");
		
		Patio patio1 = new Patio(null, "Patio 01", 10.00, 50);
		Patio patio2 = new Patio(null, "Patio 02", 10.00, 50);
		
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Estacionamento parking = new Estacionamento(null);

		Periodo pe1 = new Periodo(null, carro1, patio1, sdf.parse("20/07/2018 14:30") , sdf.parse("20/07/2018 15:30"), 10.0);
		Periodo pe2 = new Periodo(null, carro2, patio1, sdf.parse("20/07/2018 14:20") , sdf.parse("20/07/2018 16:30"), 15.00);
		Periodo pe3 = new Periodo(null, carro3, patio2, sdf.parse("20/07/2018 14:30") , sdf.parse("20/07/2018 16:30"), 20.00);
		Periodo pe4 = new Periodo(null, carro4, patio2, sdf.parse("20/07/2018 14:30") , sdf.parse("20/07/2018 15:30"), 10.00);
		Periodo pe5 = new Periodo(null, carro5, patio2, sdf.parse("20/07/2018 14:30") , sdf.parse("20/07/2018 16:30"), 12.00);
		Periodo pe6 = new Periodo(null, carro6, patio2, sdf.parse("20/07/2018 14:30") , sdf.parse("20/07/2018 14:50"), 12.00);

		cli1.getVeiculos().addAll(Arrays.asList(carro1, carro2));
		cli2.getVeiculos().addAll(Arrays.asList(carro3, carro4, carro5));
		cli3.getVeiculos().addAll(Arrays.asList(carro6));

		patio1.setEstacionamento(parking);
		patio2.setEstacionamento(parking);
		
		patio1.getVeiculos().addAll(Arrays.asList(carro1, carro2));
		patio2.getVeiculos().addAll(Arrays.asList(carro3, carro4, carro5, carro6));
	
		carro1.setCliente(cli1);
		carro2.setCliente(cli1);
		carro3.setCliente(cli2);
		carro4.setCliente(cli2);
		carro5.setCliente(cli2);
		carro6.setCliente(cli3);
		
		carro1.setPatio(patio1);
		carro2.setPatio(patio1);
		carro3.setPatio(patio2);
		carro4.setPatio(patio2);
		carro5.setPatio(patio2);
		carro6.setPatio(patio2);
		
		carro1.setPeriodo(pe1);
		carro2.setPeriodo(pe2);
		carro3.setPeriodo(pe3);
		carro4.setPeriodo(pe4);
		carro5.setPeriodo(pe5);
		carro6.setPeriodo(pe6);
		
		pe1.setVeiculo(carro1);
		pe2.setVeiculo(carro2);
		pe3.setVeiculo(carro3);
		pe4.setVeiculo(carro4);
		pe5.setVeiculo(carro5);
		pe6.setVeiculo(carro6);
		
		pe1.setPatio(patio1);
		pe2.setPatio(patio1);
		pe3.setPatio(patio2);
		pe4.setPatio(patio2);
		pe5.setPatio(patio2);
		pe6.setPatio(patio2);

		estacionamentoRepository.saveAll(Arrays.asList(parking));
		
		patioRepository.saveAll(Arrays.asList(patio1, patio2));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		
		veiculoRepository.saveAll(Arrays.asList(carro1, carro2, carro3, carro4, carro5, carro6));
		
		periodoRepository.saveAll(Arrays.asList(pe1, pe2, pe3, pe4, pe5, pe6));
		
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		

	}

}
