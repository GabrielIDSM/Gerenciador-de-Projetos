# Gerenciador de Projetos (Hibernate / PostgreSQL)

![Snap](https://github.com/GabrielIDSM/Gerenciador-de-Projetos-Hibernate-Postgres/blob/master/Imagens/SnapPrincipal.png)

## Sobre o Projeto

O **Gerenciador de Projetos** tem por objetivo tornar dinâmico e prático as metas de um projeto. Por meio de uma interface simples e uso de cadastro de usuários é possível organizar as tarefas que devem ser feitas em um projeto.

O **Gerenciador** oferece suporte para múltiplos projetos e diversos cadastros. Todo projeto possui um, e somente um, **gerente**, que possui ferramentas exclusivas de gestão.

Todos os usuários cadastrados no sistema podem acessar e modificar qualquer projeto. Apenas gerentes podem aprovar uma tarefa como **Feita**.

## Banco de Dados

Essa versão do gerenciador utiliza o framework **Hibernate** com **JPA** para fazer conexão com o Banco de Dados. O desenvolvimento do projeto utilizou um servidor **PostgreSQL**.

O projeto já conta com dependências necessárias: **PostgreSQL Connector 42.2.14** e **Hibernate 5.4.17**.

Para configurar o projeto para outra máquina deve-se modificar o arquivo **persistence.xml**, presente no pacote **META-INF**.

## Interface

O **Gerenciador de Projeto** tem uma interface baseado no **Método Kanban**. O Método Kanban utiliza um sistema de controle de fluxo baseado em **post-it's**, que usa cores para sinalizar detalhes.

Esse método divide as tarefas em três níveis: **Para Fazer**, **Fazendo** e **Feito**. Cadas um dos estágios possuem propriedades e características próprias.

Apenas gerentes podem classificar uma tarefa como **feita** para organizar melhor as responsbilidades dos membros da equipe. Porém qualquer usuário pode criar tarefas.

## Colaboradores e Contato
O Projeto é pessoal, feito por Gabriel Inácio ([Github](https://github.com/GabrielIDSM)/[LinkedIn](https://www.linkedin.com/in/gabriel-inacio-uff/)).

E-mail: gabrielinacio@id.uff.br

