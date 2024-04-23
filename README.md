### Descrição do Projeto `list-shop-cqrs`

O projeto `list-shop-cqrs` é um exemplo prático que demonstra a implementação do padrão arquitetural CQRS (Command Query Responsibility Segregation) em uma aplicação Java. O CQRS é um padrão que separa as operações de leitura (query) das operações de escrita (command) em um sistema, permitindo uma maior flexibilidade e escalabilidade na arquitetura.

Neste projeto, o CQRS é utilizado em um cenário de uma lista de compras, onde é possível adicionar e remover itens da lista, bem como consultar os itens presentes na lista. A separação entre as operações de escrita e leitura permite que a aplicação seja mais eficiente e fácil de escalar, uma vez que as operações de leitura não são afetadas pelo volume de operações de escrita.

O projeto utiliza diversas tecnologias modernas do ecossistema Java, como Qarkus, Panache , Lombok e Mysql. Ele serve como um exemplo didático de como implementar o padrão CQRS em uma aplicação Java e pode ser usado como base para projetos que necessitam dessa arquitetura.
