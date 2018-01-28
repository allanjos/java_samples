1. Habilitar acesso via TCP/IP utilizando "Sql Server Configuration Manager"

2. Criar usuário para acesso ao banco com utilização de senha:

exec sp_configure 'contained database authentication', 1
GO

reconfigure
GO

alter database <database_name> set containment = partial
GO

CREATE USER <user_name> WITH PASSWORD='<password>', DEFAULT_LANGUAGE=[Brazilian], DEFAULT_SCHEMA=[<database_name>];
GO

3. Reiniciar serviço do banco de dados "Sql Server (MSSQLSERVER)".