package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue vilageois " + nomVisiteur);
					StringBuilder questionForce = new StringBuilder();
					questionForce.append("Quel est votre force ?");
					int force = Clavier.entrerEntier(questionForce.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder questionForce = new StringBuilder();
		StringBuilder questionForceMax = new StringBuilder();
		StringBuilder questionForceMin = new StringBuilder();
		System.out.println("Bienvenue druide " + nomVisiteur);
		questionForce.append("Quelle est votre force ?");
		int forceDruide = Clavier.entrerEntier(questionForce.toString());
		int effetPotionMax = -1;
		int effetPotionMin = -1;
		do {
			questionForceMin.append("Quelle est la force de potion la moins forte que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(questionForceMin.toString());
			questionForceMax.append("Quelle est la force de potion la plus forte que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier(questionForceMax.toString());
			if(effetPotionMax<effetPotionMin)
			{
				System.out.println("Attention Druide, vouv vous êtes trompé entre le minimum et le maximum\n");
			}
		} while (effetPotionMax<effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur,forceDruide, effetPotionMin, effetPotionMax);
	}
}
