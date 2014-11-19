package Gerenciador;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaConsultas extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private final List<Consulta> consultas;

	public TabelaConsultas(List<Consulta> consultas){
		this.consultas = consultas;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return consultas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Consulta n = consultas.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return n.getPacienteNome();
		case 1:
			return n.getPacienteIdade();
		case 2:
			return n.getMedicoNome();
		case 3:
			return n.getMedicoEspecialidade();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Paciente";
		case 1:
			return "Idade";
		case 2:
			return "Medico";
		case 3:
			return "Especialidade";
		}
		return "";
	}

}
