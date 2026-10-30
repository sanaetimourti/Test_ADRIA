# Frontend Angular (partie G)

À la racine du dépôt :
```bash
npm install -g @angular/cli
ng new frontend --routing --style css
cd frontend
ng serve
```

Créer les composants :
```bash
ng g c components/dashboard
ng g c components/accounts
ng g c components/transactions
ng g c components/transfers
ng g c components/chatbot
ng g s services/account
ng g s services/transaction
ng g s services/chat
```

API Gateway : `http://localhost:8080`; AI Agent : `http://localhost:8085`. Activer CORS côté backend ou configurer un proxy Angular de développement. Les pages doivent appeler les services Angular via `HttpClient`.
