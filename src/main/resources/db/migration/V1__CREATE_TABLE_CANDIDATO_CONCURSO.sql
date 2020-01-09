CREATE TABLE candidato(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    cpf INT NOT NULL UNIQUE
);

CREATE TABLE concurso(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    nota_corte DECIMAL NOT NULL
);

CREATE TABLE candidato_concurso(
    candidato_id INT,
    concurso_id INT,
    nota DECIMAL NOT NULL,
    CONSTRAINT PK_CandidatoConcurso PRIMARY KEY (candidato_id, concurso_id),
    CONSTRAINT FK_CandidatoConcursoCandidato FOREIGN KEY (candidato_id) REFERENCES candidato(id) ON DELETE CASCADE,
    CONSTRAINT FK_CandidatoConcursoConcurso FOREIGN KEY (concurso_id) REFERENCES concurso(id) ON DELETE CASCADE
);

