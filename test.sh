#!/bin/bash

url=$(minikube service apigateway -n instagnam --url=true)

echo -e "Connessioni:"

echo -e "\nOutput atteso:"

echo -e '[{"id":1,"follower":"Cristiano","followed":"Gennaro"},{"id":2,"follower":"Gennaro","followed":"Cristiano"},{"id":3,"follower":"Paolo","followed":"Cristiano"},{"id":4,"follower":"Paolo","followed":"Gennaro"},{"id":5,"follower":"Anna","followed":"Antonino"},{"id":6,"follower":"Anna","followed":"Benedetta"}]'

echo -e "\n\nOutput reale:"
curl $url/connessioni

echo -e "\n ---------------------------------------------------------------------------------------------------------------------------------------- "

echo -e "\n\nRicette:"

echo -e "\nOutput atteso:"

echo -e '[{"id":1,"autore":"Cristiano","titolo":"Panino al prosciutto"},{"id":2,"autore":"Cristiano","titolo":"Pizza e mortazza"},{"id":3,"autore":"Gennaro","titolo":"Tonno e fagioli"},{"id":4,"autore":"Antonino","titolo":"Pizza margherita"},{"id":5,"autore":"Benedetta","titolo":"Tonno e fagioli"}]'

echo -e "\n\nOutput reale:"
curl $url/ricette

echo -e "\n ---------------------------------------------------------------------------------------------------------------------------------------- "

echo -e "\n\nRicette seguite da Gennaro:"

echo -e "\nOutput atteso:"

echo -e '[{"id":1,"autore":"Cristiano","titolo":"Panino al prosciutto"},{"id":2,"autore":"Cristiano","titolo":"Pizza e mortazza"}]'

echo -e "\n\nOutput reale:"
curl $url/ricetteseguite/Gennaro

echo -e "\n ---------------------------------------------------------------------------------------------------------------------------------------- "

echo -e "\n\nRicette di Cristiano (Gennaro segue solo Cristiano quindi la lista di ricette deve essere uguale alle ricette seguite da Gennaro):"

echo -e "\nOutput atteso:"

echo -e '[{"id":1,"autore":"Cristiano","titolo":"Panino al prosciutto"},{"id":2,"autore":"Cristiano","titolo":"Pizza e mortazza"}]'

echo -e "\nOutput reale:"
curl $url/ricette?autore={Cristiano}

echo -e "\n ---------------------------------------------------------------------------------------------------------------------------------------- "

echo -e "\n\nConnessioni di Gennaro (Gennaro segue solo Cristiano):"

echo -e "\nOutput atteso:"

echo -e '[{"id":2,"follower":"Gennaro","followed":"Cristiano"}]'

echo -e "\nOutput reale:"
curl $url/connessioni?follower={Gennaro}

echo -e






