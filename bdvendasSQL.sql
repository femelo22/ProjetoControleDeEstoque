-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Ago-2020 às 22:08
-- Versão do servidor: 10.4.8-MariaDB
-- versão do PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdvendas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_clientes`
--

CREATE TABLE `tb_clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_fornecedores`
--

CREATE TABLE `tb_fornecedores` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cnpj` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_fornecedores`
--

INSERT INTO `tb_fornecedores` (`id`, `nome`, `cnpj`, `email`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(5, 'Nestle', '01.472.583/6900-00', 'rafamel@gmail.com', '(32) 3 2125 - 5554', '(32) 9 9987 - 8787', '25814 - 700', 'Rua olegário maciel', 2000, '201', 'Dom Bosco', 'Juiz de Fora', 'MG'),
(6, 'Piracamjuba', '98.741.236/5000-00', 'teste@gmail.com', '(32) 1 2231 - 2121', '(99) 3 3523 - 3516', '65165 - 156', 'teste', 201, 'teste', 'teste', 'teste', 'AC'),
(7, 'Papelaria do Joao', '  .   .   /    -  ', 'papeljoao@hotmail.com', '(32) 9 9999 - 9999', '(32) 9 9999 - 9999', '54456 - 454', 'gsdfghsgsfgsdfgsd', 65445, 'sdfgsdfhg', 'fgbjdfkbh', 'fjsdgjgb', 'RJ');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_funcionarios`
--

CREATE TABLE `tb_funcionarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `senha` varchar(10) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `nivel_acesso` varchar(50) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_funcionarios`
--

INSERT INTO `tb_funcionarios` (`id`, `nome`, `rg`, `cpf`, `email`, `senha`, `cargo`, `nivel_acesso`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(1, 'Ricardo ', '19-12.212.021', '125.457.546-54', 'ricardo@hotmail.com', '', 'Gerente', 'Usuário', '(32) 9 3212 - 9985', '(32) 9 9955 - 4111', '36205 - 451', 'Rua Fulano de tal', 1111, 'Gerente', 'Ipiranguinha', 'Juiz de Fora', 'MG'),
(3, 'Joao ', '11-11.111.111', '124.175.776-49', 'luiz@gmail.com', '123456', 'Desenvolvedor', 'Administrador', '(  )        -     ', '(32) 9 9915 - 4454', '36021 - 670', 'Coronel vaz de melo', 124, 'Desenvolvedor', 'Bom Pastor', 'Juiz de Fora', 'MG'),
(4, 'Luiz ', '00-19.601.510', '123.456.789-00', 'lf.melo', '123', 'Desenvolvedor', 'Administrador', '(32) 3212 - 8892', '(32) 9 9995 - 6148', '36021 - 670', 'endereço teste', 100, 'Desenvolvedor', 'Centro', 'testelandia', 'MG'),
(5, 'Administrador', '00-19.601.510', '654.321.987-52', 'admin', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_itensvendas`
--

CREATE TABLE `tb_itensvendas` (
  `id` int(11) NOT NULL,
  `venda_id` int(11) DEFAULT NULL,
  `produto_id` int(11) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_itensvendas`
--

INSERT INTO `tb_itensvendas` (`id`, `venda_id`, `produto_id`, `qtd`, `subtotal`) VALUES
(1, 15, 3, 10, '45.00'),
(2, 15, 5, 3, '13.50'),
(3, 15, 5, 3, '14.10'),
(4, 16, 1, 10, '40.00'),
(5, 19, 3, 5, '22.50'),
(6, 20, 2, 13, '39.00'),
(7, 21, 3, 2, '9.00'),
(8, 22, 5, 20, '94.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_produtos`
--

CREATE TABLE `tb_produtos` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `qtd_estoque` int(11) DEFAULT NULL,
  `for_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_produtos`
--

INSERT INTO `tb_produtos` (`id`, `descricao`, `preco`, `qtd_estoque`, `for_id`) VALUES
(1, 'Coca-Cola 1l', '4.00', 40, 5),
(2, 'Chocolate em Pó nestle', '3.00', 7, 6),
(3, 'Manteiga barra 250G', '4.50', 28, 5),
(5, 'Biscoito de maizena', '4.70', 10, 6),
(6, 'Caneta Azul', '1.00', 100, 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_vendas`
--

CREATE TABLE `tb_vendas` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) UNSIGNED DEFAULT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total_venda` decimal(10,2) DEFAULT NULL,
  `observacoes` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_vendas`
--

INSERT INTO `tb_vendas` (`id`, `cliente_id`, `data_venda`, `total_venda`, `observacoes`) VALUES
(0, 0, '2020-06-02 00:00:00', '45.00', ''),
(1, 0, '2020-05-25 00:00:00', '450.00', ''),
(3, 2, '2020-05-25 12:50:23', '450.20', 'Manteiga'),
(5, 0, '2020-06-02 00:00:00', '90.00', 'Chocolate em pó'),
(6, 2, '2020-06-02 00:00:00', '225.00', ''),
(7, 2, '2020-06-02 00:00:00', '45.00', ''),
(8, 3, '2020-06-04 00:00:00', '47.00', ''),
(9, 4, '2020-06-11 00:00:00', '9.40', 'Entregar no endereço\n\nBom pastor Rua Principal'),
(10, 5, '2020-06-02 00:00:00', '45.00', 'nenhuma'),
(11, 3, '2020-06-04 00:00:00', '45.00', ''),
(12, 3, '2020-06-04 00:00:00', '45.00', ''),
(13, 2, '2020-06-11 00:00:00', '47.00', ''),
(14, 2, '2020-06-11 00:00:00', '90.00', 'nenhuma'),
(15, 5, '2020-06-11 00:00:00', '72.60', 'sem nada'),
(16, 5, '2020-06-11 00:00:00', '40.00', ''),
(17, 3, '2020-06-11 00:00:00', '240.00', ''),
(18, 2, '2020-06-11 00:00:00', '200.00', ''),
(19, 2, '2020-07-01 00:00:00', '22.50', 'Manteiga com sal'),
(20, 0, '2020-07-01 00:00:00', '39.00', ''),
(21, 0, '2020-07-01 00:00:00', '9.00', ''),
(22, 0, '2020-07-24 00:00:00', '94.00', '');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_clientes`
--
ALTER TABLE `tb_clientes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_fornecedores`
--
ALTER TABLE `tb_fornecedores`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_funcionarios`
--
ALTER TABLE `tb_funcionarios`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_itensvendas`
--
ALTER TABLE `tb_itensvendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tb_itensvendas_ibfk_2` (`produto_id`),
  ADD KEY `tb_itensvendas_ibfk_1` (`venda_id`);

--
-- Índices para tabela `tb_produtos`
--
ALTER TABLE `tb_produtos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tb_produtos_ibfk_1` (`for_id`);

--
-- Índices para tabela `tb_vendas`
--
ALTER TABLE `tb_vendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tb_vendas_ibfk_1` (`cliente_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_clientes`
--
ALTER TABLE `tb_clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `tb_fornecedores`
--
ALTER TABLE `tb_fornecedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `tb_funcionarios`
--
ALTER TABLE `tb_funcionarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tb_itensvendas`
--
ALTER TABLE `tb_itensvendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `tb_produtos`
--
ALTER TABLE `tb_produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_itensvendas`
--
ALTER TABLE `tb_itensvendas`
  ADD CONSTRAINT `tb_itensvendas_ibfk_1` FOREIGN KEY (`venda_id`) REFERENCES `tb_vendas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_itensvendas_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `tb_produtos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `tb_produtos`
--
ALTER TABLE `tb_produtos`
  ADD CONSTRAINT `tb_produtos_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_fornecedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
