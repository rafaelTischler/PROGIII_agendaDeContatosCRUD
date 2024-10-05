package agenda_CRUD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Arquivo {
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo;

	public Arquivo(String arquivo) {
		this.arquivo = arquivo;
		try {
			br = new BufferedReader(new FileReader(this.arquivo + ".txt"));
			br.close();
		} catch (IOException e) {
			try {
				bw = new BufferedWriter(new FileWriter(this.arquivo + ".txt"));
				bw.close();
			} catch (IOException e1) {
				System.out.println("Erro na criação do arquivo: " + e.getMessage());
			}
		}
	}

	public void gravarContato(Contato contato) {
		try {
			bw = new BufferedWriter(new FileWriter(this.arquivo + ".txt", true));
			bw.write(contato.getNome() + "," + contato.getEmail() + "," + contato.getTelefone() + "," + contato.getTipo());
			bw.write("\n");
			bw.close();
		} catch (Exception e) {
			System.out.println("Erro na abertura de arquivo para gravação: " + e.getMessage());
		}
	}

	public LinkedList<Contato> lerContato() {
		String linha;
		String[] info;
		LinkedList<Contato> listaContatos = new LinkedList<>();
		try {
			br = new BufferedReader(new FileReader(this.arquivo + ".txt"));
			while ((linha = br.readLine()) != null) {
				info = linha.split(",");
				Contato contato = new Contato(info[0], info[1], info[2], info[3]);
				listaContatos.add(contato);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Erro na abertura de arquivo para leitura: " + e.getMessage());
		}
		return listaContatos;
	}

	public void alterarContato(String nomeAntigo, Contato contato) {
		LinkedList<Contato> listaContatos = new LinkedList<>();
		String linha;
		try (BufferedReader br = new BufferedReader(new FileReader(this.arquivo + ".txt"))) {
			while ((linha = br.readLine()) != null) {
				String[] info = linha.split(",");
				Contato novoContato = new Contato(info[0], info[1], info[2], info[3]);
				if (info[0].equals(nomeAntigo)) {
					novoContato = contato;
					System.out.println(novoContato.getNome());
				}
				listaContatos.add(novoContato);
			}
		} catch (IOException e) {
			System.out.println("Erro na abertura de arquivo para leitura: " + e.getMessage());
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.arquivo + ".txt"))) {
			for (Contato contatoNovo : listaContatos) {
				bw.write(contatoNovo.getNome() + "," + contatoNovo.getEmail() + "," + contatoNovo.getTelefone() + "," + contatoNovo.getTipo());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	public void alterarContato(LinkedList<Contato> contatos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.arquivo + ".txt"))) {
			for (Contato contato : contatos) {
				bw.write(contato.getNome() + "," + contato.getEmail() + "," + contato.getTelefone() + "," + contato.getTipo());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	public void removerContato(String nome) {
		LinkedList<Contato> listaContatos = new LinkedList<>();
		String linha;
		try (BufferedReader br = new BufferedReader(new FileReader(this.arquivo + ".txt"))) {
			while ((linha = br.readLine()) != null) {
				String[] info = linha.split(",");
				Contato contato = new Contato(info[0], info[1], info[2], info[3]);
				if (!info[0].equals(nome)) {
					listaContatos.add(contato);
				} else {
					System.out.println("Contato removido: " + info[0]); // JOptionPane
				}
			}
		} catch (IOException e) {
			System.out.println("Erro na abertura de arquivo para leitura: " + e.getMessage());
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.arquivo + ".txt"))) {
			for (Contato contato : listaContatos) {
				bw.write(contato.getNome() + "," + contato.getEmail() + "," + contato.getTelefone() + "," + contato.getTipo());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}
}
