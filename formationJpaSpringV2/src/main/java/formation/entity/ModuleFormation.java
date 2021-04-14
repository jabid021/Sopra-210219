package formation.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "module_formation")
public class ModuleFormation {
	@EmbeddedId
	private ModuleFormationPK id;
	@Column(name = "date_module")
	private LocalDate dateModule;
	@ManyToOne
	@JoinColumn(name = "id_intervenant", foreignKey = @ForeignKey(name = "module_formation_id_intervenant_fk"))
	private Formateur intervenant;
	@Version
	private int version;

	public ModuleFormation() {

	}

	public ModuleFormationPK getId() {
		return id;
	}

	public void setId(ModuleFormationPK id) {
		this.id = id;
	}


	public LocalDate getDateModule() {
		return dateModule;
	}

	public void setDateModule(LocalDate dateModule) {
		this.dateModule = dateModule;
	}

	public Formateur getIntervenant() {
		return intervenant;
	}

	public void setIntervenant(Formateur intervenant) {
		this.intervenant = intervenant;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleFormation other = (ModuleFormation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
