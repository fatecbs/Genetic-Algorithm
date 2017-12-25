package view;

import genetic_algorithm.Algorithm;
import genetic_algorithm.City;
import genetic_algorithm.Population;
import genetic_algorithm.TourManager;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Screen extends JPanel {
    
    private Population population;
    
    private int generations = 0;
    
    private boolean createdCities = false;
    private boolean startedPopulation = false;
    
    private JButton btnCreateCities = new JButton("Generate cities");
    private JButton btnStart = new JButton("START");
    private JButton btn10 = new JButton("+10 generations");
    private JButton btn50 = new JButton("+50 generations");
    private JButton btn100 = new JButton("+100 generations");
    private JButton btn1000 = new JButton("+1000 generations");
    private JButton btnReset = new JButton("Reset");
    private JLabel lblNumberCities = new JLabel("Number of cities:");
    private JLabel lblPopulationSize = new JLabel("Population size:");
    private JLabel lblTournmentSize = new JLabel("Tournment size:");
    private JLabel lblMutationRate = new JLabel("Mutation rate:");
    private JTextField txtNumberCities = new JTextField("50");
    private JTextField txtPopulationSize = new JTextField("100");
    private JTextField txtTournmentSize = new JTextField("5");
    private JTextField txtMutationRate = new JTextField("0.015");
    private JPanel panelTextArea = new JPanel();
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollpane = new JScrollPane(textArea);
    
    public Screen() {
        this.setLayout(null);
        this.setBackground(new Color(26, 47, 67));
        initializeComponents();
    }
    
    private void initializeComponents() {
        // Configuring components
        btnCreateCities.setBounds(650,30,155,30);
        btnCreateCities.setBackground(new Color(137, 17, 17));
        btnCreateCities.setForeground(Color.WHITE);
        btnCreateCities.setFocusPainted(false);
        btnCreateCities.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        btnStart.setBounds(650,70,155,30);
        btnStart.setBackground(new Color(37, 137, 77));
        btnStart.setForeground(Color.WHITE);
        btnStart.setFocusPainted(false);
        btnStart.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        btn10.setBounds(650,110,155,30);
        btn10.setBackground(new Color(57, 106, 121));
        btn10.setForeground(Color.WHITE);
        btn10.setFocusPainted(false);
        btn10.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        btn50.setBounds(650,150,155,30);
        btn50.setBackground(new Color(57, 106, 121));
        btn50.setForeground(Color.WHITE);
        btn50.setFocusPainted(false);
        btn50.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        btn100.setBounds(650,190,155,30);
        btn100.setBackground(new Color(57, 106, 121));
        btn100.setForeground(Color.WHITE);
        btn100.setFocusPainted(false);
        btn100.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        btn1000.setBounds(650,230,155,30);
        btn1000.setBackground(new Color(57, 106, 121));
        btn1000.setForeground(Color.WHITE);
        btn1000.setFocusPainted(false);
        btn1000.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        btnReset.setBounds(650,270,155,30);
        btnReset.setBackground(new Color(65, 67, 65));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFocusPainted(false);
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        lblNumberCities.setBounds(825,30,100,30);
        lblNumberCities.setForeground(Color.LIGHT_GRAY);
        lblPopulationSize.setBounds(832,70,100,30);
        lblPopulationSize.setForeground(Color.LIGHT_GRAY);
        lblTournmentSize.setBounds(830,110,100,30);
        lblTournmentSize.setForeground(Color.LIGHT_GRAY);
        lblMutationRate.setBounds(843,150,100,30);
        lblMutationRate.setForeground(Color.LIGHT_GRAY);
        
        txtNumberCities.setBounds(930,33,40,25);
        txtPopulationSize.setBounds(930,73,40,25);
        txtTournmentSize.setBounds(930,113,40,25);
        txtMutationRate.setBounds(930,153,40,25);
        
        textArea.setEditable(false);
        textArea.setLineWrap(false);
        textArea.setBackground(new Color(22, 40, 58));
        textArea.setForeground(Color.LIGHT_GRAY);
        panelTextArea.setLayout(new BorderLayout());
        panelTextArea.setBounds(650, 314, 320, 167);
        panelTextArea.add(scrollpane);
        
        // Adding components to JPanel
        this.add(btnCreateCities);
        this.add(btnStart);
        this.add(btn10);
        this.add(btn50);
        this.add(btn100);
        this.add(btn1000);
        this.add(btnReset);
        this.add(lblNumberCities);
        this.add(lblPopulationSize);
        this.add(lblTournmentSize);
        this.add(lblMutationRate);
        this.add(txtNumberCities);
        this.add(txtPopulationSize);
        this.add(txtTournmentSize);
        this.add(txtMutationRate);
        this.add(panelTextArea);
        
        // Adding actions
        btnCreateCities.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (startedPopulation == false)
                {
                    createdCities = true;
                    TourManager.cities.clear();
                    Algorithm.qtdCities = Integer.parseInt(txtNumberCities.getText());
                    Algorithm.tamPop = Integer.parseInt(txtPopulationSize.getText());
                    Algorithm.tournmentSize = Integer.parseInt(txtTournmentSize.getText());
                    Algorithm.mutationRate = Double.parseDouble(txtMutationRate.getText());
                    Random rcity = new Random();
                    for (int i=0; i<Algorithm.qtdCities; i++)
                    {
                        City city = new City(rcity.nextInt(200), rcity.nextInt(150));
                        TourManager.addCity(city);
                    }
                    repaint();
                }
            }
        });
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(createdCities)
                {
                    if (startedPopulation == false)
                    {
                        startedPopulation = true;
                        Algorithm.qtdCities = Integer.parseInt(txtNumberCities.getText());
                        Algorithm.tamPop = Integer.parseInt(txtPopulationSize.getText());
                        Algorithm.tournmentSize = Integer.parseInt(txtTournmentSize.getText());
                        Algorithm.mutationRate = Double.parseDouble(txtMutationRate.getText());
                        population = new Population(Algorithm.tamPop, true);
                        textArea.append("Initial distance: " + population.getFittest().getTotalDistance() + "\n");
                        txtPopulationSize.setEditable(false);
                        repaint();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Crie as cidades primeiro", null, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        btn10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(createdCities == false)
                {
                    JOptionPane.showMessageDialog(null, "Crie as cidades primeiro", null, JOptionPane.INFORMATION_MESSAGE);
                }
                else if(startedPopulation == false)
                {
                    JOptionPane.showMessageDialog(null, "Inicie a população primeiro", null, JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    Algorithm.qtdCities = Integer.parseInt(txtNumberCities.getText());
                    Algorithm.tamPop = Integer.parseInt(txtPopulationSize.getText());
                    Algorithm.tournmentSize = Integer.parseInt(txtTournmentSize.getText());
                    Algorithm.mutationRate = Double.parseDouble(txtMutationRate.getText());
                    addGenerations(10);
                }
            }
        });
        btn50.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(createdCities == false)
                {
                    JOptionPane.showMessageDialog(null, "Crie as cidades primeiro", null, JOptionPane.INFORMATION_MESSAGE);
                }
                else if(startedPopulation == false)
                {
                    JOptionPane.showMessageDialog(null, "Inicie a população primeiro", null, JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    Algorithm.qtdCities = Integer.parseInt(txtNumberCities.getText());
                    Algorithm.tamPop = Integer.parseInt(txtPopulationSize.getText());
                    Algorithm.tournmentSize = Integer.parseInt(txtTournmentSize.getText());
                    Algorithm.mutationRate = Double.parseDouble(txtMutationRate.getText());
                    addGenerations(50);
                }
            }
        });
        btn100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(createdCities == false)
                {
                    JOptionPane.showMessageDialog(null, "Crie as cidades primeiro", null, JOptionPane.INFORMATION_MESSAGE);
                }
                else if(startedPopulation == false)
                {
                    JOptionPane.showMessageDialog(null, "Inicie a população primeiro", null, JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    Algorithm.qtdCities = Integer.parseInt(txtNumberCities.getText());
                    Algorithm.tamPop = Integer.parseInt(txtPopulationSize.getText());
                    Algorithm.tournmentSize = Integer.parseInt(txtTournmentSize.getText());
                    Algorithm.mutationRate = Double.parseDouble(txtMutationRate.getText());
                    addGenerations(100);
                }
            }
        });
        btn1000.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(createdCities == false)
                {
                    JOptionPane.showMessageDialog(null, "Crie as cidades primeiro", null, JOptionPane.INFORMATION_MESSAGE);
                }
                else if(startedPopulation == false)
                {
                    JOptionPane.showMessageDialog(null, "Inicie a população primeiro", null, JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    Algorithm.qtdCities = Integer.parseInt(txtNumberCities.getText());
                    Algorithm.tamPop = Integer.parseInt(txtPopulationSize.getText());
                    Algorithm.tournmentSize = Integer.parseInt(txtTournmentSize.getText());
                    Algorithm.mutationRate = Double.parseDouble(txtMutationRate.getText());
                    addGenerations(1000);
                }
            }
        });
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createdCities = false;
                startedPopulation = false;
                population = null;
                txtPopulationSize.setEditable(true);
                textArea.setText(null);
                generations = 0;
                repaint();
            }
        });
    }
    
    private void addGenerations(int numGenerations) {
        for (int i=0; i<numGenerations; i++)
        {
            generations++;
            population = Algorithm.newGeneration(population);
            textArea.append("Generation: " + generations + "\tBest: " + population.getFittest().getTotalDistance() + "\n");
            textArea.update(textArea.getGraphics());
            this.paintImmediately(0, 0, 620, 540);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Cartesian background
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(26, 47, 67));
        g2.drawRect(29, 29, 603, 453);
        g2.setColor(new Color(40, 40, 40));
        g2.fillRect(30, 30, 600, 450);
        // Cartesian plane
        // Axis X
        g2.setStroke(new BasicStroke(1));
        int aux = 0;
        for(int i=30; i<=630; i=i+30)
        {
            g2.setColor(new Color(110, 110, 110));
            g2.draw(new Line2D.Float(0+i, 30, 0+i, 480));
            g2.setColor(Color.LIGHT_GRAY);
            g2.drawString(""+aux, (0+i)-9, 500);
            aux = aux + 10;
        }
        // Axis Y
        int aux2 = aux-60;
        for(int i=30; i<=480; i=i+30)
        {
            g2.setColor(new Color(110, 110, 110));
            g2.draw(new Line2D.Float(30, 0+i, 630, 0+i));
            g2.setColor(Color.LIGHT_GRAY);
            g2.drawString(""+aux2, 5, (0+i)+6);
            aux2 = aux2 - 10;
        }
        
        // Creating the cities
        if (createdCities)
        {
            for(int i=0; i<Algorithm.qtdCities; i++)
            {
                g2.setColor(new Color(67, 137, 172));
                g2.fillOval((TourManager.getCity(i).getX()*3)+25, 500-((TourManager.getCity(i).getY()*3)+25), 10, 10);
                g2.setColor(Color.white);
                g2.drawString(""+(i+1), (TourManager.getCity(i).getX()*3)+25, (500-((TourManager.getCity(i).getY()*3)+25))-6);
            }
        }
        // Creating the path
        if (startedPopulation)
        {
            g2.setColor(new Color(51, 151, 81));
            g2.setStroke(new BasicStroke(2));
            int lastcity = 0;
            for (int i=0; i<(Algorithm.qtdCities-1); i++)
            {
                g2.draw(new Line2D.Float(((population.getFittest().getCity(i).getX()*3)+25)+5, (500-((population.getFittest().getCity(i).getY()*3)+25))+5, ((population.getFittest().getCity(i+1).getX()*3)+25)+5, (500-((population.getFittest().getCity(i+1).getY()*3)+25))+5));
                lastcity = i;
            }
        }
    }
    
}