public class FormateurDeDuree {

    public static String formaterDuree(int secondes) {
        int[] composants = extraireComposants(secondes);
        String dureeFormatee = traiterComposants(composants);
        return dureeFormatee;
    }

    private static int[] extraireComposants(int secondes) {
        int année = secondes / (365 * 24 * 60 * 60);
        int secondesRestantes = secondes % (365 * 24 * 60 * 60);

        int jour = secondesRestantes / (24 * 60 * 60);
        secondesRestantes %= (24 * 60 * 60);

        int heure = secondesRestantes / (60 * 60);
        secondesRestantes %= (60 * 60);

        int minute = secondesRestantes / 60;
        secondesRestantes %= 60;

        return new int[]{année, jour, heure, minute, secondesRestantes};
    }

    private static String traiterComposants(int[] composants) {
        StringBuilder résultat = new StringBuilder();

        if (composants[0] > 0) {
            résultat.append(composants[0]).append(composants[0] > 1 ? " années" : " année").append(", ");
        }
        if (composants[1] > 0) {
            résultat.append(composants[1]).append(composants[1] > 1 ? " jours" : " jour").append(", ");
        }
        if (composants[2] > 0) {
            résultat.append(composants[2]).append(composants[2] > 1 ? " heures" : " heure").append(", ");
        }
        if (composants[3] > 0) {
            résultat.append(composants[3]).append(composants[3] > 1 ? " minutes" : " minute").append(" et ");
        }
        résultat.append(composants[4]).append(composants[4] > 1 ? " secondes" : " seconde");

        int longueur = résultat.length();
        if (résultat.charAt(longueur - 1) == ' ' && résultat.charAt(longueur - 2) == ',') {
            résultat.delete(longueur - 2, longueur);
        }

        return résultat.toString();
    }
}
