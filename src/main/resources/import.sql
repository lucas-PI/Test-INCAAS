INSERT INTO tb_proce_judi (numero_processo, vara, comarca, status) VALUES ('2345678-12.2023.8.26.0101', '1 Vara Civel', 'Campinas', 'ATIVO');
INSERT INTO tb_proce_judi (numero_processo, vara, comarca, status) VALUES ('3456789-34.2023.8.26.0102', '3 Vara de Familia', 'Santos', 'SUSPENSO');
INSERT INTO tb_proce_judi (numero_processo, vara, comarca, status) VALUES ('4567890-56.2023.8.26.0103', '5 Vara Criminal', 'Ribeirao Preto', 'ARQUIVADO');
INSERT INTO tb_proce_judi (numero_processo, vara, comarca, status) VALUES ('5678901-78.2023.8.26.0104', '2 Vara Civel', 'Osasco', 'ATIVO');
INSERT INTO tb_proce_judi (numero_processo, vara, comarca, status) VALUES ('6789012-90.2023.8.26.0105', '4 Vara do Trabalho', 'Osasco', 'ATIVO');

INSERT INTO tb_audiencia (data_audiencia, hora, local, tipo_audiencia, processo_judi_id) VALUES ('2025-06-20', '14:30:00', 'Fórum Central - Sala 2', 'INSTRUCAO', 1);
INSERT INTO tb_audiencia (data_audiencia, hora, local, tipo_audiencia, processo_judi_id) VALUES ('2025-06-20', '09:00:00', 'Fórum Central - Sala 1', 'CONCILIACAO', 1);
INSERT INTO tb_audiencia (data_audiencia, hora, local, tipo_audiencia, processo_judi_id) VALUES ('2025-06-19', '11:30:00', 'Fórum Central - Sala 3', 'JULGAMENTO', 3);
INSERT INTO tb_audiencia (data_audiencia, hora, local, tipo_audiencia, processo_judi_id) VALUES ('2025-06-25', '14:00:00', 'Fórum Central - Sala 2', 'INSTRUCAO', 4);
INSERT INTO tb_audiencia (data_audiencia, hora, local, tipo_audiencia, processo_judi_id) VALUES ('2025-06-10', '15:30:00', 'Fórum Central - Sala 1', 'CONCILIACAO', 5);
